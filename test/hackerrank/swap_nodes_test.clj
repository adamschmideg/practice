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

(def tree-0
  {:val 1
   :left {:val 2}
   :right {:val 3}})

(def paths-0
  [[[]]
   [[:left] [:right]]])

(def tree-1
  {:val 1
   :left {:val 2
          :right {:val 4}}
   :right {:val 3
           :right {:val 5}}})

(def paths-1
  [[[]]
   [[:left] [:right]]
   [[:left :right] [:right :right]]])


(deftest parse-tree-test
  (are [nodes tree-expect saved-paths-expect]
    (let [[tree-result _ saved-paths-result] (parse-tree nodes)]
      (is (= tree-result tree-expect))
      (is (= saved-paths-result saved-paths-expect)))
    [2 3 nil 4 nil 5 nil nil nil nil]
    tree-1
    paths-1))

(deftest assoc-dissoc-in-test
  (is (= (assoc-dissoc-in {:foo {:bar 2, :baz 3}} [:foo :bar] nil)
        {:foo {:baz 3}}))
  (is (= (assoc-dissoc-in {:foo {:baz 3}} [:foo :bar] 2)
        {:foo {:bar 2, :baz 3}})))

(deftest swap-at-test
  ;(are [tree path tree-expect] (is (= (swap-at tree path) tree-expect)))
  (are [tree path tree-expect] (is 1)
    tree-0
    []
    {:val 1
     :left {:val 3}
     :right {:val 2}}

    tree-1
    []
    {:val 1
      :left {:val 3
              :right {:val 5}}
      :right {:val 2
              :right {:val 4}}}

    tree-1
    [:left]
    {:val 1
     :left {:val 2
            :left {:val 4}}
     :right {:val 3
             :right {:val 5}}}))

(deftest swap-nodes-at-test
  (is (= (swap-nodes-at tree-1 paths-1 0)
        {:val 1
         :left {:val 3
                :right {:val 5}}
         :right {:val 2
                 :right {:val 4}}}))
  (is (= (swap-nodes-at tree-1 paths-1 1)
         {:val 1
          :left {:val 2
                 :left {:val 4}}
          :right {:val 3
                  :left{:val 5}}})))

(deftest traverse-in-order-test
  (is (= (traverse-in-order tree-1)
        [2 4 1 3 5])))

(deftest multiples-test
  (is (= (multiples 2 8)
         [2 4 6 8])))

(deftest swap-nodes-at-multiples-test
  (is (= (swap-nodes-at-multiples tree-0 paths-0 [1 2])
        {:val 1
         :left {:val 3}
         :right {:val 2}})))

(deftest swapNodes-test
  (are [indexes queries expected] (is (= (swapNodes indexes queries) expected))
    [[2 3] [-1 -1] [-1 -1]]
    [1 1]
    [[3 1 2] [2 1 3]]

    [[2 3] [4 5] [6 -1] [-1 7] [8 9] [10 11] [12 13] [-1 14] [-1 -1] [15 -1] [16 17] [-1 -1] [-1 -1] [-1 -1] [-1 -1] [-1 -1] [-1 -1]]
    [2 3]
    [[14 8 5 9 2 4 13 7 12 1 3 10 15 6 17 11 16]
     [9 5 14 8 2 13 7 12 4 1 3 17 11 16 6 10 15]]

    [[2 3] [4 -1] [5 -1] [6 -1] [7 8] [-1 9] [-1 -1] [10 11] [-1 -1] [-1 -1] [-1 -1]]
    [2 4]
    [[2 9 6 4 1 3 7 5 11 8 10]
     [2 6 9 4 1 3 7 5 10 8 11]]))

(run-tests)
