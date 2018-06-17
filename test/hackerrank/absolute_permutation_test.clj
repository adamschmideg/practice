(ns hackerrank.absolute-permutation-test
  (:require [clojure.test :refer :all]
            [hackerrank.absolute-permutation :refer :all]))

(deftest all
  (is (= (absolutePermutation 2 1)
        [2 1]))
  (is (= (absolutePermutation 3 0)
        [1 2 3]))
  (is (= (absolutePermutation 3 1)
         -1))
  (is (= (absolutePermutation 4 2)
         [3 4 1 2])))

(deftest swap-test
  (is (= (swap [1 2 3 4])
         [3 4 1 2]))
  (is (= (swap [1 2]) [2 1])))

(run-tests)
