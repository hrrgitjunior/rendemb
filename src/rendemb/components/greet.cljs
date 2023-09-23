(ns rendemb.components.greet
  (:require [ajax.core :refer [GET POST]]
            [reagent.core :as r]
            [re-frame.core :as rf]))

(defn handler [response]
  (.log js/console "server responded...")
  (js/console.log response)
  (let [resjs
        (-> (clj->js response)  (aget  "body" "greeting"))]
    (r/render [:div.col-lg-12.col-lg-offset-3
               [:h3 (str "Hello From " resjs)]]
               ;[:button {:on-click
               ;          (fn []
               ;            (rf/dispatch [:test-db {:value "OK"}]))}
               ; "Test Reframe"]]

              (.getElementById js/document "maincontainer-id"))))


(defn error-handler [{:keys [status status-text]}]
  (.log js/console (str "something bad happened: " status " " status-text)))

(defn say-hello []
  (GET "/hello"
        {:params {:user "from Server!"}
         :handler handler
         :error-handler error-handler
         :format :json
         :response-format :json}))

