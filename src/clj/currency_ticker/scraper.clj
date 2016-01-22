(ns currency-ticker.scraper
  (:require [net.cgrand.enlive-html :as html]))

(defn get-rates [league want have]
  (let [url (html/html-resource (java.net.URL. (str "http://currency.poe.trade/search?league=" league "&online=&want=" want "&have=" have)))]
    (map html/text (html/select url [:div.displayoffer-middle]))))

(defn get-ratios [raw-list]
  (map /
       (map (fn [s] (read-string (first (clojure.string/split s #" ")))) raw-list)
       (map (fn [s] (read-string (nth (clojure.string/split s #" ") 2))) raw-list)))

