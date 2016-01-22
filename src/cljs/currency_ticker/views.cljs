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
      (conj [com/single-dropdown :filter-box? true :width "200px" :model nil :placeholder "Talisman" :on-change #(re-frame/dispatch [:league %1])
             :choices]
            (mapv (fn [[id value]] {:label value :id id}) @leagues))
      ]])

;(defn rate-display [

(defn main-panel []
  (let [currencies (re-frame/subscribe [:currency]) leagues (re-frame/subscribe [:leagues])]
    (dropdown-menus currencies leagues)
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
