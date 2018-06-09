(ns hackerrank.bomberman-test
  (:require [clojure.test :refer :all]
            [hackerrank.bomberman :refer :all]))

(deftest replace-test
  (is (= (replace-grid {0 \., 1 \0} [[0 1] [1 0]])
         [[\. \0] [\0 \.]]))
  (is (= (replace-grid {\. 0, \0 1} [".0" "0."])
         [[0 1] [1 0]])))

(deftest explode-test
  (is (= (explode-and-plant [[0 0 1] [0 0 0]])
         [[1 0 0] [1 1 0]])))

(deftest stringify-test
  (is (= (stringify [[\0 \0] [\. \.]])
         "00\n..")))

(deftest numbered-bomberman-test
  (is (= (numbered-bomberman 2 [[9 9] [9 9]])
         [[1 1] [1 1]]))
  (is (= (numbered-bomberman 3 [[1 0] [0 1]])
         [[0 0] [0 0]])))

(deftest flexible-bomberman-test
  (is (= (flexible-bomberman 3 ["00" ".."] (fn [n grid] grid))
         "00\n..")))

(deftest bomberman-test
  (is (= (bomberMan 2 ["0.0" "..."])
         "000\n000")))

(run-tests)
