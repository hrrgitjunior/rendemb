(ns rendemb.core
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [reagent.core :as r]
            [goog.dom]
            [cljs.core.async :as async :refer [<! chan close! put!]]
            [cljs-http.client :as http]))

(def by-id goog.dom.getElement)

(defn app-container []
  [:div
   [:h1 {}
    "Hello World 123"]
   [:button
    {:on-click
     (fn []
       (go
         (let [res (<! (http/get "/hello"))]
           (println "====" res))))}
    "Button 1"]])


(r/render-component [app-container] (by-id "app"))

;;; Install the service worker
(when (exists? js/navigator.serviceWorker)
  (-> js/navigator
      .-serviceWorker
      (.register "/sw.js")
      (.then #(js/console.log "Server worker registered."))))
