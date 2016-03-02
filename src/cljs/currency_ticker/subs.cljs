(ns currency-ticker.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]
              [org.httpkit.client :as http]
              [cljs.reader :refer [read-string]]))

(re-frame/register-sub
  :currency
  (fn [db, _]
    (reaction (:currency @db))))

(re-frame/register-sub
  :league
  (fn [db _]
    (reaction (:league @db))))

(re-frame/register-sub
  :reference
  (fn [db _]
    (reaction (:reference @db))))

(re-frame/register-sub
  :leagues
  (fn [db _]
    (reaction (:leagues @db))))

;(re-frame/register-sub
;  :rates
;  (fn [db _]
;    (reaction (:rates @db))))

(re-frame/register-sub
  :rates
  (fn [db _]
    (let [league (:league @db) reference (:reference @db)]
      (read-string (http/get (str "/data/" league "/processed-" (name reference) ".txt")))
      )))
