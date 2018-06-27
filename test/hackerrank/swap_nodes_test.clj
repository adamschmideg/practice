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

(run-tests)
