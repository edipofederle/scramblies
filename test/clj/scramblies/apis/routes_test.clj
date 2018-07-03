(ns scramblies.apis.routes-test
  (:require [cheshire.core :as json]
            [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [scramblies.apis.resources.scramble :as s]
            [scramblies.services.http :as http]))

(deftest scramble-api
  (testing "Testing scramble API endpoint"
    (with-redefs [s/scramble? (fn [s1 s2] true)]
      (let [body (json/generate-string {:s1 "testing" :s2 "test"})
            request (-> (mock/request :post "/api/scramble" body)
                        (mock/content-type "application/json"))
            response (http/app request)]
        (is (= (:status response) 200))))))
