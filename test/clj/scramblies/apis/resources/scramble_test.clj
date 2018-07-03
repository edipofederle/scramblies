(ns scramblies.apis.resources.scramble-test
  (:require [clojure.test :refer :all]
            [scramblies.apis.resources.scramble :as r]))

(deftest scramble?-test
  (testing "Testing scramble? predicate"
    (is (false? (r/scramble? nil nil)))
    (is (false? (r/scramble? "test" nil)))
    (is (false? (r/scramble? nil "test")))
    (is (true? (r/scramble? "rekqodlw" "world")))
    (is (true? (r/scramble? "cedewaraaossoqqyt" "codewars")))
    (is (false? (r/scramble? "katas" "steak")))
    (is (false? (r/scramble? "impresso" "gesso")))))
