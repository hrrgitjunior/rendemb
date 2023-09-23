(ns rendemb.backend.excercises)
  ;(:require  [com.rpl.specter :as spct]))

(defn exc-1 []
  (let [d [["aaa" 10] ["bbb" 20]]]
    (->> d
         (mapv (fn [[n v]] v))
         (filterv #(> % 10)))))

(defn exc-2 []
  (let [d [{:cost 10} {:cost 20} {:cost 30}]]
    (->> d
         (reduce
           (fn [acc {:keys [cost]}]
             (if (> cost 10)
               (conj acc cost)
               acc))
           []))))




