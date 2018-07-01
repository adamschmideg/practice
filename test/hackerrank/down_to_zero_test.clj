(ns hackerrank.down-to-zero-test
  (:require [clojure.test :refer :all]
            [hackerrank.down-to-zero :refer :all]))

(deftest greatest-div-test
  (are [n greatest] (is (= (greatest-div n) greatest))
    9 [3]
    8 [4]
    7 []
    12 [4 6]))

(deftest downToZero-test
  (are [n down] (is (= (downToZero n) down))
    2 2
    3 3
    4 3))

(deftest hackerrank.down-to-zero-test
  (are [n down] (is (= (down-to-zero n) down))
    8 [1 2 4 8]
    6 [1 2 3 6]))

(run-tests)
