(ns rendemb.reframe-core
  (:require [cljs.core.async :as a]
            [reagent.core :as r]
            [re-frame.core :as rf]))

;(defonce app-db (r/atom {:state {}}))

(rf/reg-event-db
  :test-db
  (fn [db [_ param]]
    (cljs.pprint/pprint db)
    (assoc db :test param)))

(rf/reg-event-db
  :select-rows
  (fn [db [_ new-selection]]
    (assoc db :selected-rows new-selection)))

(rf/reg-sub
  :selected-rows
  (fn [db _]
    (:selected-rows db)))


