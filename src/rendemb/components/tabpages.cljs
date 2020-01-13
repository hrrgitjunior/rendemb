(ns rendemb.components.tabpages
  (:require [reagent.core :as r]
            [goog.dom]
            [rendemb.reducer :refer [dispatch!]]))

(defn tab-page [children]
  [:div
    children])

(defn tab-pages-component []
  (let [page-number (r/atom 1)
        did-mount
        (fn [])

        render
        (fn []
          (let [props (r/props (r/current-component))]
            [:div
              [:div
                [:button
                  {:on-click (fn [] (reset! page-number 1))}
                  "Tab 1"]
                [:button
                  {:on-click (fn [] (reset! page-number 2))}
                  "Tab 2"]]

              [tab-page (case @page-number
                          1 [:div "PAGE 1"]
                          2 [:div "PAGE 2"])]]))]



    (r/create-class
      {:component-did-mount did-mount
       ;; name your component for inclusion in error messages
       :display-name "tab-pages-component"

       ;; note the keyword for this method
       :reagent-render render})))
