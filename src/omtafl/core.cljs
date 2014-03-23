(ns omtafl.core
  (:require [om.core :as om :include-macros true]
            [tafl.core :as tafl]
            [tafl.render :as taflrend]))

(enable-console-print!)

(def app-state (atom (tafl/init-state)))

(om/root
  (fn [app owner]
    (tafl/render app))
  app-state
  {:target (. js/document (getElementById "app"))})