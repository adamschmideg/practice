(ns hackerrank.two-pluses-test
  (:require [clojure.test :refer :all]
            [hackerrank.two-pluses :refer :all]))

(deftest all-good-test
  (let [grid ["GG" "BB"]]
    (is (all-good? grid #{[0 0] [0 1]}))
    (is (not (all-good? grid #{[0 0] [9 9]})))
    (is (not (all-good? grid #{[0 0] [1 1]})))))


(deftest two-pluses-test
  (let [grid ["GGB" "GGG" "GGG"]]
    (is (= (pluses grid 0 2)
           [#{}]))
    (is (= (pluses grid 0 1)
           [#{[0 1]}]))
    (is (= (pluses grid 1 1)
           [#{[1 1]} #{[0 1] [1 1] [2 1] [1 0] [1 2]}]))))

(deftest two-pluses-test
  (is (= 5 (twoPluses ["GGG" "GGG" "BGB"]))))

(run-tests)
