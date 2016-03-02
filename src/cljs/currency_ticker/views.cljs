(ns currency-ticker.views
    (:require [re-frame.core :as re-frame]
              [re-com.core :as com]))

(defn dropdown-menus [currencies leagues]
  [com/h-box :justify :center :gap "15px" :align :center
     :children ["Reference Currency:"
      (conj [com/single-dropdown :filter-box? true :width "200px" :model :4 :on-change #(re-frame/dispatch [:reference %1])
             :choices]
            (mapv (fn [[id value]] {:label value :id id}) @currencies))

      "League:"
      (conj [com/single-dropdown :filter-box? true :width "200px" :model :T :on-change #(re-frame/dispatch [:league %1])
             :choices]
            (mapv (fn [[id value]] {:label value :id id}) @leagues))
      ]])

(defn currency-display [data currencies reference]
  [:div
   (doall (map (partial (fn [currencies index entry]
                          (let [cur-key (keyword (str index))]
                            [:div {:key index}
                             [:div {:key (str index (cur-key currencies))} (get currencies cur-key)]
                             [:div {:key (str index "top values")} (str (first entry) " " (second entry))]
                             [:img {:key (str index "img" 1) :src (str "currency_images/" (clojure.string/replace (cur-key currencies) #" " "_") ".png") :alt (clojure.string/replace (cur-key currencies) #" " "_") :width "25px" :height "25px"}]
                             [:div {:key (str index "arrow right")} " ------>  1 "]
                             [:div {:key (str index "arrow right 2")} (str "1 <------ ")]
                             [:div {:key (str index "values")} (str (nth entry 3) " " (nth entry 2) " ")]
                             [:img {:key (str index "img" 4) :src (str "currency_images/" (clojure.string/replace (@reference currencies) #" " "_") ".png") :alt (clojure.string/replace (@reference currencies) #" " "_") :width "25px" :height "25px"}]
                             [:div {:key (str index "refcur 2")} (@reference currencies)] ;" Chaos")];
                             ]))
                        @currencies)
                        (sort (reduce conj (range 1 (js/parseInt (name @reference))) (range (+ (js/parseInt (name @reference)) 1) 26)))
                        @data))])


;(defn rate-display [

(defn main-panel []
  (let [currencies (re-frame/subscribe [:currency]) leagues (re-frame/subscribe [:leagues]) rates (re-frame/subscribe [:rates]) reference (re-frame/subscribe [:reference])]
    [:div
     (dropdown-menus currencies leagues)
     (currency-display rates currencies reference)
     ]
      ))

;[:img {:src "currency_images/armourer's_scrap.png" :alt "armourer's scrap" :width "25px" :height "25px"}]
;;2 alt : 1 jewel
;;4 jewel : 1 fus
;;3 jewel : 1 chrome
;;3 wis : 1 portal
;;4 trans : 1 aug
;;4 chance : 1 scour
;;4 aug : 1 alt
;;7 portal : 1 trans
;;2 scour : 1 regret
;;1 fusing : 1 chance
;;1 regret : 1 alch


; <div class="dropdown">
;  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Dropdown Example
;  <span class="caret"></span></button>
;  <ul class="dropdown-menu">
;    <li><a href="#">HTML</a></li>
;    <li><a href="#">CSS</a></li>
;    <li><a href="#">JavaScript</a></li>
;  </ul>
;</div>
