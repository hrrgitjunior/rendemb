(ns rendemb.components.layout
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [reagent.core :as r]
            [goog.dom]
            [goog.dom]
            [cljs-http.client :as http]
            [rendemb.reducer :refer [dispatch!]]
            [rendemb.components.tabpages :refer [tab-pages-component]]
            [rendemb.components.greet :as greet]
            [rendemb.components.service :refer [chart-plot-service]]
            [rendemb.components.datatable :refer [dtable]]))

(defn layout-component []
  (let [did-mount
        (fn [])

        render
        (fn []
          (let [props (r/props (r/current-component))
                {:keys [name]} props]
            [:div.container-fluid {:style {:height "800px" :background-color "#ffa" :margin "10px"}}
             [:div.row {:style {:height "50px" :background-color "#eff"}}
              [:h4 {:style {:margin-left 20}}
               (str "Интерактивно представяне на готов проект за машинна бродерия")]]
             [:div.row
               [:div.col-lg-10 {:style {:height "750px" :background-color "#dff"}}
                [tab-pages-component]]
               [:div.col-lg-2 {:style {:height "750px" :background-color "#eff"}}
                [:input {:type "text" :id "layouted"}]
                [:button
                  {:on-click
                    (fn []
                      (go
                       (let [res (<! (http/post "/design"))]
                         (dispatch! {:type :layout :name
                                     (-> js/document
                                       (.getElementById "layouted")
                                       (.-value))}))))}
                  "Dispatch"]]]]))]

    (r/create-class
      {:component-did-mount did-mount
       ;; name your component for inclusion in error messages
       :display-name "layout-component"

       ;; note the keyword for this method
       :reagent-render render})))

(defonce dashboard (r/atom {}))
(defn app-render []
  [:div.row
   [:div.col-lg-2
    [:nav.navbar.navbar-expand-lg.navbar-dark.bg-dark.fixed-top {:id "mainNav"}
     [:div.collapse.navbar-collapse {:id "navbarResponsive"}
      ;
      [:ul.navbar-nav.navbar-sidenav {:id "exampleAccordion"}
       ;[:ul {:style {:list-style-type "none"}}]

       [:li.nav-item {:data-toggle "tooltip"
                      :data-placement "right"
                      :title "Dashboard"}
        [:a.nav-link { :href "javascript:"
                      :on-click
                      (fn [e]
                        (println "TEST AJAX 123 ===")
                        (greet/say-hello))}

         [:i.fa.fa-fw.fa-dashboard]
         [:span.nav-link-text "Test Ajax"]]]

       [:li.nav-item {:data-toggle "tooltip"
                      :data-placement "right"
                      :title "Dashboard"}
        [:a.nav-link { :href "javascript:"
                      :on-click
                      (fn [e]
                        (reset! dashboard nil)
                        (chart-plot-service "histogram"))}
       [:i.fa.fa-fw.fa-dashboard
         [:span.nav-link-text "Histogram"]]]]

       [:li.nav-item {:data-toggle "tooltip"
                      :data-placement "right"
                      :title "Dashboard"}
        [:a.nav-link { :href "javascript:"
                      :on-click
                      (fn [e]
                        (dtable {:container (.getElementById js/document "maincontainer-id")})
                        (reset! dashboard "dtable"))}
         [:i.fa.fa-fw.fa-dashboard]
         [:span.nav-link-text "Datatable"]]]]]]]

   ;----- main container --Dashboard---
   [:div.col-lg-10
      [:div {:id "maincontainer-id"
             :style
             {:height "600px"
              :width "100%"
              :margin-top "50px"}}
            ;(case @dashboard
            ;  "dtable" [dtable]
            ;  [:div "Does not selected active dashboard"])
            ]]])

