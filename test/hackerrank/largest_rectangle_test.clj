(ns hackerrank.largest-rectangle-test
  (:require [clojure.test :refer :all]
            [hackerrank.largest-rectangle :refer :all]))

(deftest greatest-streak-test
  (are [xs n greatest] (is (= (greatest-streak xs n) greatest))
    [2 3 2 1 4] 2 6
    [2 3 2 1 4] 3 3))

(deftest hackerrank.largest-rectangle-test
  (is (= (largestRectangle [1 2 3 4 5])
        9)))

(run-tests)
