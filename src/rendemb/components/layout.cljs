(ns rendemb.components.layout
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [reagent.core :as r]
            [goog.dom]
            [goog.dom]
            [cljs-http.client :as http]
            [rendemb.reducer :refer [dispatch!]]
            [rendemb.components.tabpages :refer [tab-pages-component]]))

(defn layout-component []
  (let [did-mount
        (fn [])

        render
        (fn []
          (let [props (r/props (r/current-component))
                {:keys [name]} props]
            (println "=== RENDER LAYOUT ===" name)
            [:div
              [:h1 (str "LAYOUT123-"name)]
              [:input {:type "text" :id "layouted"}]
              [:button
                {:on-click
                  (fn []
                    (go
                     (let [res (<! (http/post "/design"))]
                       (println "====" (get-in res [:body :greeting])))))}
                       ; (dispatch! {:type :layout :name
                       ;             (-> js/document
                       ;               (.getElementById "layouted")
                       ;               (.-value))}))))}
                "Dispatch"]

              [tab-pages-component]]))]

    (r/create-class
      {:component-did-mount did-mount
       ;; name your component for inclusion in error messages
       :display-name "layout-component"

       ;; note the keyword for this method
       :reagent-render render})))
