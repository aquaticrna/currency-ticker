(ns currency-ticker.db)
  ;(:require [cljs.reader :as reader]))

;(defn get-ratios "needs to return a map, the result of the map call should look like '([:key []] [:key []])"[league]
;  (map (fn [orb]
;         (let [data (reader/read-string (slurp (str "resources/public/data/" league "/" orb "-processed.txt")))]
;           [(keyword (str orb)) data]
;           ))
;       (range 1 26)))

(def default-db
  {:currency {:1 "Orb of Alteration",
              :2 "Orb of Fusing",
              :3 "Orb of Alchemy",
              :4 "Chaos Orb",
              :5 "Gemcutter's Prism",
              :6 "Exalted Orb",
              :7 "Chromatic Orb",
              :8 "Jeweller's Orb",
              :9 "Orb of Chance",
              :10 "Cartographer's Chisel",
              :11 "Orb of Scouring",
              :12 "Blessed Orb",
              :13 "Orb of Regret",
              :14 "Regal Orb",
              :15 "Divine Orb",
              :16 "Vaal Orb",
              :17 "Scroll of Wisdom",
              :18 "Portal Scroll",
              :19 "Armourer's Scrap",
              :20 "Blacksmith's Whetsone",
              :21 "Glassblower's Bauble",
              :22 "Orb of Transmutation",
              :23 "Orb of Augmentation",
              :24 "Mirror of Kalandra",
              :25 "Eternal Orb"},
   :leagues {:T "Talisman", :TH "Talisman+Hardcore", :S "Standard", :H "Hardcore"},
   ;:rates (into {} (get-ratios "Talisman"))
   :league "Talisman",
   :reference :4
   })


;(map read-string (clojure.string/split (slurp (str "resources/public/data/" league "/want-" orb ".txt")) #"\n") )
