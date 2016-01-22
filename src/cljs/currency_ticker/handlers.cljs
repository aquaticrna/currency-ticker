(ns currency-ticker.handlers
    (:require [re-frame.core :as re-frame]
              [currency-ticker.db :as db]))

(re-frame/register-handler
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/register-handler
  :rates
  (fn [_ _]))

(re-frame/register-handler
  :league
  (fn [db [_ league_key]]
    (assoc db :league (league_key (:leagues db)))))

(re-frame/register-handler
  :reference
  (fn [db [_ ref_key]]
    (assoc db :reference ref_key)))
