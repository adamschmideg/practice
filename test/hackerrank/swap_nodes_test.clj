(ns hackerrank.swap-nodes-test
  (:require [clojure.test :refer :all]
            [hackerrank.swap-nodes :refer :all]))

(deftest add-node-test
  (are [tree active-paths saved-paths node tree-out active-paths-out saved-paths-out]
    (let [[tree-result active-paths-result saved-paths-result] (add-node tree active-paths saved-paths node)]
      (is (= tree-result tree-out))
      (is (= active-paths-result active-paths-out))
      (is (= saved-paths-result saved-paths-out)))
    ; simple
    {:val 1, :left {:val 3}}
    [[[:right]]
     [[:left :left], [:left :right]]]
    [[[:left]]]
    :new

    {:val 1, :left {:val 3}, :right {:val :new}}
    [[]
     [[:left :left], [:left :right], [:right :left], [:right :right]]]
    [[[:left] [:right]]]

    ; new level starts
    {:val 1, :left {:val 2}, :right {:val 3}}
    [[]
     [[:left :left], [:left :right], [:right :left], [:right :right]]]
    [[[:left] [:right]]]
    :new

    {:val 1,
     :left {:val 2,
            :left {:val :new}}
     :right {:val 3}}
    [[]
     [[:left :right], [:right :left], [:right :right]]
     [[:left :left :left] [:left :left :right]]]
    [[[:left] [:right]]
     [[:left :left]]]

    ; add empty node
    {:val 1}
    [[[:left] [:right]]]
    []
    nil

    {:val 1}
    [[[:right]]]
    []))

(deftest parse-tree-test
  (is (= (parse-tree [2 3 nil 4 nil 5 nil nil nil nil])
        {:val 1
         :left {:val 2
                :right {:val 4}}
         :right {:val 3
                 :right {:val 5}}})))

(deftest next-path-test
  (are [path next] (is (= (next-path path) next)) ;(str "Got: "(next-path path))))
    [:left :left] [:left :right]
    [:left :right] [:right :left]
    [:right :right] [:right :left :left]))

(run-tests)
