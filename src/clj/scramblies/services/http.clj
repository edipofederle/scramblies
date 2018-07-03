(ns scramblies.services.http
  (:require [compojure.core :refer [defroutes GET routes wrap-routes]]
            [compojure.route :as r]
            [org.httpkit.server :as server]
            [ring.middleware.format :as restful]
            [ring.middleware.reload :as reload]
            [ring.util.http-response :as response]
            [scramblies.apis.routes :as apis]
            [scramblies.templates :as t]))

(defroutes app
  (-> (routes
       (r/resources "/")
       (GET "/" [] (response/ok (t/index-html)))
       (wrap-routes apis/routes restful/wrap-restful-format))
      reload/wrap-reload))

(defonce server (atom nil))

(defn stop-server!
  []
  (when-not (nil? @server)
    (@server :timeout 100)
    (reset! server nil)))

(defn start-server!
  []
  (reset! server (server/run-server app {:port 8080})))
