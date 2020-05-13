(ns portfolio-pie.composition.pie
  (:require [portfolio-pie.assets.grouping :refer [group-assets]]))

(defn add-total-values [assets]
  (reduce #(+ %1 (:total-value %2)) 0 assets))

(defn value-asset-group [group-totals [atype assets]]
  (assoc group-totals atype (add-total-values assets)))

(defn value-asset-groups [asset-groups]
  (reduce value-asset-group  {} asset-groups))

(defn value-portfolio [group-totals]
  (reduce #(+ %1 (second %2)) 0 group-totals))

(defn record-group-percent
  [group-percents [atype total] portfolio-value]
  (assoc group-percents atype (* 100 (/ total portfolio-value))))

(defn record-group-percents [group-totals]
  (let [portfolio-value (value-portfolio group-totals)]
    (reduce #(record-group-percent %1 %2 portfolio-value)
            {}
            group-totals)))

(defn type-composition [assets]
  (-> assets
      group-assets
      value-asset-groups
      record-group-percents))
