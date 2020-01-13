(ns rendemb.reducer
  (:require-macros [cljs.core.async.macros :refer [go go-loop]])
  (:require [cljs.core.async :as a]
            [reagent.core :as r]
            [rendemb.reducers.layout :refer [Action]]))


; (defmethod Action :layout [state {:keys [type] :as action-data}]
;   (prn "=== Action Layout ===")
;   state)

(defonce !state (r/atom {}))
(defonce !actions (a/chan))

(defn dispatch! [action]
  (a/put! !actions action))

(go-loop []
  (when-let [a (a/<! !actions)]
    (println "===============")
    (println a)
    ;(swap! !state Action a)
    ;(cljs.pprint/pprint @!state)
    (recur)))
