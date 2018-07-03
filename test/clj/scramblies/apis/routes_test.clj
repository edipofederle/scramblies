(ns scramblies.apis.routes-test
  (:require [cheshire.core :as json]
            [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [scramblies.apis.resources.scramble :as s]
            [scramblies.apis.routes :as r]
            [scramblies.services.http :as http]))

(deftest scramble-test
  (testing "Testing scramble function"
    (with-redefs [s/scramble? (fn [s1 s2] true)]
      (is (= (r/scramble {:s1 "testing" :s2 "test"})
             {:scramble? true})))))

(deftest scramble-route-test
  (testing "Testing scramble API endpoint"
    (with-redefs [s/scramble? (fn [s1 s2] true)]
      (let [body (json/generate-string {:s1 "testing" :s2 "test"})
            request (-> (mock/request :post "/api/scramble" body)
                        (mock/content-type "application/json"))
            response (http/app request)]
        (is (= (:status response) 200))))))
