(ns rendemb.components.datatable
  (:require [reagent.core :as r]
            [re-frame.core :as rf])
  (:use [jayq.core :only [$ delegate toggle]]))

(def data [{:employeeId 1 :name "Hristo" :city "Gabrovo"}
           {:employeeId 2 :name "Ivan" :city "Ruse"}
           {:employeeId 3 :name "Stoian" :city "Plovdiv"}])

(def columns [{:data "select" :title "Select"}
              {:data "employeeId" :title "Employee"}
              {:data "name" :title "Name"}
              {:data "city" :title "City"}])

(def column-defs [{:targets 0
                   :searcheble false
                   :orderable false
                   :className "dt-body-center"
                   :render (fn [data type row meta]
                             (let [row-id (.. row -employeeId)
                                   selected-row
                                   (->> @(rf/subscribe [:selected-rows])
                                        (filterv #(= (str (.. row -employeeId)) %)))]
                               (str  "<input type=\"checkbox\" name=\"employeeId[]\"" "id = " "\"" row-id "\""
                                     (if (seq selected-row) "checked>" ">"))))}])

(defn update-checkbox [new-selection]
  (let [check-bs (js/$ "tbody input[type = \"checkbox\"")]
    (->> (range (count check-bs)) (mapv
                                    (fn [idx]
                                      (if (contains? new-selection (aget check-bs idx "id"))
                                       (aset check-bs idx "checked" true)
                                       (aset check-bs idx "checked" false)))))))


(defn row-click [e self table-handle]
  (let [row-data-id
        (-> (.. table-handle (row self) (data))
            (js->clj :keywordize-keys true) (get :employeeId) str)
        selected-row-ids @(rf/subscribe [:selected-rows])
        new-selection
        (cond
          (empty? selected-row-ids) #{row-data-id}
          (contains? selected-row-ids row-data-id)
          (->> selected-row-ids
               (filterv #(not (= % row-data-id)))
               set)
          (not (contains? selected-row-ids row-data-id))
          (conj selected-row-ids row-data-id))]
    (update-checkbox new-selection)
    (rf/dispatch-sync [:select-rows new-selection])))

(defn dtable [props]
  (let [{:keys [container plot]} props
        table-handle (r/atom nil)
        table-id (str "table" (rand-int 100000))
        dom-node (r/atom nil)

        did-mount
        (fn [this]
          (reset! table-handle
            (. (js/$ (r/dom-node this)) DataTable
               (clj->js {:columnDefs column-defs :columns columns :data data})))
          (let [on-event (.. @table-handle -on)]
            (on-event "click" "tbody tr"
                      (fn [e]
                        (this-as self
                          (row-click e self @table-handle))))))

        will-unmount
        (fn [this]
          (.destroy @table-handle)
          (.. (js/$ (r/dom-node this)) (empty) (addClass "dataTable")))


        render
        (fn []
          [:table { :ref #(reset! dom-node %)
                    :style {:width "100%"}
                    :class "table table-bordered table-hover dataTable no-footer"
                    :id table-id}])]

    (r/render [
               (r/create-class
                  { :component-did-mount did-mount
                    :component-will-unmount will-unmount
                    :reagent-render render})]
              container)))




