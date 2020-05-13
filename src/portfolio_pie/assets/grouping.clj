(ns portfolio-pie.assets.grouping
  (:require [portfolio-pie.assets.map :refer [asset-type-map]]))

(defn get-type [asset]
  (get asset-type-map (:symbol asset)))

(defn place-in-group [groups asset]
  (let [atype (get-type asset)]
    (assoc groups
           atype
           (conj (atype groups) asset))))

(defn group-assets [assets]
  (reduce place-in-group
          {:bond [] :stock []}
          assets))
