(ns scramblies.ajax
  (:require [ajax.core :as ajax]))

(defn post-request
  [uri params on-success on-error]
  {:http-xhrio {:method          :post
                :uri             uri
                :params          params
                :format          (ajax/json-request-format)
                :response-format (ajax/json-response-format {:keywords? true})
                :on-success      on-success
                :on-failure      on-error}})
