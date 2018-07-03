(ns scramblies.core
  (:gen-class)
  (:require [scramblies.services.http :as http]))

(defn -main
  [& args]
  (http/start-server!))
