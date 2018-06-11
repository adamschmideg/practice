(ns hackerrank.larrys-array-test
  (:require [clojure.test :refer :all]
            [hackerrank.larrys-array :refer :all]))

(deftest all
  (testing "rotate"
    (is (= (rotate [2 3 4] 1) [3 4 2]))
    (is (= (rotate [2 3 4 5] 1) [3 4 2 5]))
    (is (= (rotate [2 3 4 5] 3) [2 4 5 3]))))

(run-tests)
