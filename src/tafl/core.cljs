(ns tafl.core
  (:require [tafl.init :as init]
            [tafl.render :as rend]))


(defn init-state []
  {
   :board (init/init-board)
   :turn :attacker
  })

(defn render [app]
  (rend/render app))

