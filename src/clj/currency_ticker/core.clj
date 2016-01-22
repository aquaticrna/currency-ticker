(ns currency-ticker.core
  ;;(:use '[clojure.java.io :only ])
  (:require [currency-ticker.scraper :as scraper]))

(defn mean [n]
  (/ (reduce + n) (count n)))

(defn median "sort n first" [n]
  (if (even? (count n))
    [(- (/ (count n) 2) 1) (/ (count n) 2)]
    [(int (Math/floor (/ (count n) 2)))]))

(defn quartile "min, 1st, median, 3rd, max, count"  [vals]
  (if (< (count vals) 2)
    [0 0 0 0 0 0]
    (let [svals (into [] (sort vals)) med (median svals)]
      [(first svals)
       (mean (map (partial nth svals) (median (take (+ (first med) 1) svals))))
       (mean (map (partial nth svals) med))
       (mean (map (partial nth svals) (median (nthrest svals (+ (first med) 1)))))
       (last svals)
       (count svals)])))

(defn get-quartiles [want have]
  (quartile (scraper/get-ratios (scraper/get-rates "Talisman" want have))))

(defn get-all-exchange-rates "orb is a number [1:25]" [orb league file]
  (let [other-orbs (sort (into (range 1 orb) (range (+ orb 1) 26)))]
      (doseq [other other-orbs]
        (spit (str "resources/public/data/" league file orb ".txt") (get-quartiles other orb) :append true))))

(defn daily-pull [league]
    (doseq [orb (range 1 26)]
      (println orb)
      (doseq [file ["/want-" "/have-"]]
        (spit (str "resources/public/data/" league file orb ".txt") "\n" :append true)
        (spit (str "resources/public/data/" league file orb ".txt") "[" :append true)
        (get-all-exchange-rates orb league file)
        (spit (str "resources/public/data/" league file orb ".txt") "]" :append true))))

(defn process-data [league]
  (doseq [orb (range 1 26)]
    (let [[want-yesterday want-today] (take-last 2 (map read-string (clojure.string/split (slurp (str "resources/public/data/" league "/want-" orb ".txt")) #"\n") ))
          [have-yesterday have-today] (take-last 2 (map read-string (clojure.string/split (slurp (str "resources/public/data/" league "/have-" orb ".txt")) #"\n") ))]
      (spit (str "resources/public/data/" league "/" orb "-processed.txt")
            (mapv #(-> [(second %2) (- (second %2) (second %1)) (second %4) (- (second %4) (second %3))]) want-yesterday want-today have-yesterday have-today)
            ))))


(defn run-daily []
  (doseq [league ["Standard" "Talisman" "Hardcore" "Hardcore+Talisman"]]
    (do (daily-pull league)
      (process-data league))))

(defn test-run []
  (process-data "TEST"))

(defn make-test-data []
  (doseq [orb (range 1 26)]
    (doseq [file ["want-" "have-"]]
      (let [path (str "resources/public/data/TEST/" file orb ".txt")]
        (do (spit path "[" :append true)
          (doseq [other (sort (into (range 1 orb) (range (+ orb 1) 26)))]
;            (spit path [(min orb other) (max other orb) (+ other orb) 100 (rand-int 20)] :append true))
            (spit path [(+ (min orb other) (- (rand-int 10) 5)) (+ (max other orb) (+ (rand-int 5) 5)) (+ (+ other orb) (+ (rand-int 5) 10)) (+ 100 (rand-int 100)) (rand-int 20)] :append true))
          (spit path "]" :append true)
          (spit path "\n" :append true))))))


