(ns hackerrank.swap-nodes-test
  (:require [clojure.test :refer :all]
            [hackerrank.swap-nodes :refer :all]))

(deftest add-node-test
  (are [tree active-paths saved-paths tree-out active-paths-out saved-paths-out]
    (let [[tree-result active-paths-result saved-paths-result] (add-node tree active-paths saved-paths :new)]
      (is (= tree-result tree-out))
      (is (= active-paths-result active-paths-out))
      (is (= saved-paths-result saved-paths-out)))

    {:val 1, :left {:val 3}}
    [[[:right]]
     [[:left :left], [:left :right]]]
    [[[:left]]]

    {:val 1, :left {:val 3}, :right {:val :new}}
    [[]
     [[:left :left], [:left :right], [:right :left], [:right :right]]]
    [[[:left] [:right]]]))

(deftest next-path-test
  (are [path next] (is (= (next-path path) next)) ;(str "Got: "(next-path path))))
    [:left :left] [:left :right]
    [:left :right] [:right :left]
    [:right :right] [:right :left :left]))

(run-tests)
