(ns rendemb.core
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [reagent.core :as r]
            [goog.dom]
            [cljs-http.client :as http]
            [rendemb.reducer :as rr]
            [rendemb.components.layout :refer [layout-component]]
            [rendemb.reducer]))


(def by-id goog.dom.getElement)

(defn app-container []
  [layout-component (:layout @rr/!state)])

(r/render-component [app-container] (by-id "app"))

;;; Install the service worker
(when (exists? js/navigator.serviceWorker)
  (-> js/navigator
      .-serviceWorker
      (.register "/sw.js")
      (.then #(js/console.log "Server worker registered."))))
