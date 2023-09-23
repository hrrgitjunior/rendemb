(ns rendemb.web
  (:require [compojure.core :refer [defroutes GET  POST ANY]]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.ssl :as ssl]
            [environ.core :refer [env]]
            [ring.util.response :as response]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]
            [ring.middleware.json :as middleware]
            [ring.middleware.resource :as resource]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [rendemb.backend.plotdata :as pd]))

(defroutes app-routes
  (GET "/" []
    (GET "/" [] (response/file-response "index.html" {:root "public"})))  ;

  (route/resources "/")
  (GET "/hello" []
   (response/response
       {:body {:greeting "RING SERVER"}}))

  (POST "/chart-plot" request
    (fn [req]
      (response/response
        {:body pd/histogram-chart}))))

(defn wrap-dir-index [handler]
  (fn [req]
    (handler
     (update-in req [:uri]
                #(if (= "/" %) "/index.html" %)))))

;(wrap-dir-index (wrap-defaults app-routes site-defaults))
;
(def app
  ;(wrap-dir-index (wrap-defaults app-routes site-defaults)))
   (-> app-routes
       (resource/wrap-resource "public")
       (wrap-dir-index)
       (wrap-keyword-params)
       (middleware/wrap-json-params)
       (middleware/wrap-json-response)))


(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
    (println port)
    (jetty/run-jetty (site app)
      {:port port :join? false})))
