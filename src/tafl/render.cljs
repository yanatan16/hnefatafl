(ns tafl.render
  (:require [om.dom :as dom :include-macros true]
            [clojure.string :as string]))

(defn render-cell [cell]
  (dom/div #js {:className (string/join " " (cons "cell" cell))} nil))

(defn render-row [row]
  (apply dom/div #js {:className "row"}
         (map render-cell row)))

(defn render-board [board]
  (apply dom/div #js {:className "board"}
         (map render-row board)))

(defn render [state]
  (dom/div #js {:className "game"}
           (dom/h3 nil "Hnefatafl")
           (dom/div #js {:className "board-container"}
                    (render-board (state :board)))))
