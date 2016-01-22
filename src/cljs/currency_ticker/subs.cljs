(ns currency-ticker.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/register-sub
  :currency
  (fn [db, _]
    (reaction (:currency @db))))

(re-frame/register-sub
  :rates
  (fn [_ _]))

(re-frame/register-sub
  :league
  (fn [_ _]))

(re-frame/register-sub
  :reference
  (fn [db _]
    (reaction (:reference @db))))

(re-frame/register-sub
  :leagues
  (fn [db _]
    (reaction (:leagues @db))))
