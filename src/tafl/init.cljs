(ns tafl.init)

; Setup for 11x11
(def size 11)
(def far-edge (- size 1))
(def center (/ far-edge 2))
(defn middle [n] (let [m (- center (/ (- n 1) 2))] (range m (+ n m))))
(def escape-castles [[0, 0], [far-edge, 0], [0, far-edge], [far-edge,far-edge]])
(def center-castle [center center])
(def all-castles (conj escape-castles center-castle))
(def attacker-start-positions
  (apply vector (concat
    ; back row (5 pieces)
    (apply concat (map #(list [0 %] [% 0] [far-edge %] [% far-edge]) (middle 5)))
    ; front row (single piece)
    [[1 center] [center 1] [(- far-edge 1) center] [center (- far-edge 1)]])))
(def defender-start-positions
  (apply vector (distinct (concat
    (apply concat (map #(list [center %] [% center]) (middle 5)))
    (map #(vector (+ center %1) (+ center %2)) '(-1 -1 1 1) '(-1 1 -1 1))))))
(def king-start-position center-castle)

(def clean-board
  (apply vector (take size (repeatedly #(apply vector (take size (repeat '())))))))

(defn add-tag [board tag positions]
  (.log js/console (pr-str tag) (pr-str positions) (pr-str board))
  (reduce
    (fn [board [r c]]
      (let [row (nth board r)
            cell (nth row c)]
        (assoc board r (assoc row c (conj cell tag)))))
    board
    positions))

(def board-setup [
  ['castle all-castles]
  ['center [center-castle]]
  ['escape escape-castles]
  ['attacker attacker-start-positions]
  ['defender defender-start-positions]
  ['king [king-start-position]]])

(defn init-board []
  (reduce
    (fn [board [tag poss]]
      (add-tag board tag poss))
    clean-board
    board-setup))