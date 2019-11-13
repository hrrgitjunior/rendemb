(ns rendemb.web
  (:require [compojure.core :refer [defroutes GET ANY]]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.ssl :as ssl]
            [environ.core :refer [env]]
            [ring.util.response :as response]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]
            [ring.middleware.json :as middleware]))

(defroutes app-routes
  (GET "/" []
      (response/resource-response "index.html"  {:root "public"}))
  (route/resources "/")
  (GET "/hello" [] (response/response {:body {:greeting "Ring Server"}})))


  ; (ANY "*" []
  ;   (route/not-found "<h1>404 Not found</h1>")))

(def app
  (-> app-routes
      wrap-keyword-params
      middleware/wrap-json-params
      middleware/wrap-json-response))

(defn -main [& [port]]
  (println "=========")
  (let [port (Integer. (or port (env :port) 5000))]
    (println port)
    (jetty/run-jetty (site #'app)
                     {:port port :join? false})))
