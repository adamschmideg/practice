(ns hackerrank.larrys-array-test
  (:require [clojure.test :refer :all]
            [hackerrank.larrys-array :refer :all]))

(deftest all
  (testing "rotate"
    (is (= (rotate [2 3 4] 2) [4 2 3]))
    (is (= (rotate [2 3 4 5] 2) [4 2 3 5])))

  (testing "move-and-drop-greatest"
    (is (= (move-and-drop-greatest [4 1 2 3]) [1 2 3]))
    (is (= (move-and-drop-greatest [1 3 2 4]) [3 1 2]))))

(run-tests)
