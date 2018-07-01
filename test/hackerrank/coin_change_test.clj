(ns hackerrank.coin-change-test
  (:require [clojure.test :refer :all]
            [hackerrank.coin-change :refer :all]))

(deftest getWays-test
  (are [n coins ways] (is (= (getWays n coins) ways))
    4 [1 2 3] 4
    10 [2 5 3 6] 5))

(deftest getWays-test-case-2
  (are [n coins ways] (is (= (getWays n coins) ways))
    166 [5 37 8 39 33 17 22 32 13 7 10 35 40 2 43 49 46 19 41 1 12 11 28] 96190959))

(run-tests)

