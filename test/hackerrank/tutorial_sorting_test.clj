(ns hackerrank.tutorial-sorting-test
  (:require [clojure.test :refer :all]
            [hackerrank.tutorial-sorting :refer :all]))

(def xs [1 3 5 7])

(deftest insert-test
  (are [n result] (is (= (insert xs n :new) result))
    0 [:new 1 3 5 7]
    1 [1 :new 3 5 7]
    4 [1 3 5 7 :new]))

(deftest find-or-duplicate-test
  (are [n x result] (is (= (find-or-duplicate xs n x) result))
    3 4 [false [1 3 5 7 7]]
    2 4 [false [1 3 5 5 7]]
    1 4 [true [1 3 4 5 7]]))

(deftest insertionSort1-test
  (is (= (insertionSort1 :ignore [1 3 5 7 4])
        [1 3 4 5 7])))

(run-tests)

