(ns currency-ticker.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [currency-ticker.handlers]
              [currency-ticker.subs]
              [currency-ticker.views :as views]
              [currency-ticker.config :as config]))
              ;[org.httpkit.client :as http]))

(enable-console-print!)

(when config/debug?
  (println "dev mode"))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [:initialize-db])
  (mount-root))
