(ns currency-ticker.db)

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
;   :rates '([10 -2 10 -2],[1.25 -.166 1.25 -.166],[2.25 -.25 2.25 -.25],[.33 -.08 .33 -.08],[.14 0 .14 0],[11 -1.5 11 1.5],
;           [5.336206896551724 -0.6637931034482758 5.336206896551724 -0.6637931034482758],[3 -1 3 -1],[2 -.05 2 -.05],[1 0 1 0],[1.16 .5 1.16 .5],
;           [.57 .07 .57 .07],[.66 0 .66 0],[.04 0 .04 0],[.5 -.04 .5 -.04],[150 30 150 30],[80 0 80 0],[35 4 35 4],[5 -10 5 -10],[4.75 -.25 4.75 -.25],
;           [40 0 40 0],[30 0 30 0],[0 0 0 0],[0 0 0 0]),
   :league "Talisman",
   :reference :4
   })


;(map read-string (clojure.string/split (slurp (str "resources/public/data/" league "/want-" orb ".txt")) #"\n") )
