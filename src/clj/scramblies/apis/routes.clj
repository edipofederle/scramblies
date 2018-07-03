(ns scramblies.apis.routes
  (:require [compojure.core :refer [context defroutes POST]]
            [ring.util.http-response :as response]
            [scramblies.apis.resources.scramble :as r]
            [scramblies.utils.resource :as utils]))

(defn scramble
  "Use `r/scramble?` to check whether `s1` contains letters of `s2`."
  [{s1 :s1 s2 :s2}]
  {:scramble? (r/scramble? s1 s2)})

(defroutes routes
  (context "/api" []
    (POST "/scramble" request
      (-> request
          utils/request-body->map
          scramble
          response/ok))))
