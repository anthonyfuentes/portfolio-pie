(ns portfolio-pie.composition.pie
  (:require [portfolio-pie.assets.grouping :refer [group-assets]]))

(defn add-total-values [assets]
  (reduce #(+ %1 (:total-value %2)) 0 assets))

(defn value-asset-group [group-totals [atype assets]]
  (assoc group-totals atype (add-total-values assets)))

(defn value-asset-groups [asset-groups]
  (reduce value-asset-group  {} asset-groups))

(defn value-portfolio [assets]
  (reduce #(+ %1 (:total-value %2)) 0 assets))

(defn record-group-percent
  [group-percents [atype total] portfolio-value]
  (assoc group-percents
         atype
         (* 100 (/ total portfolio-value))))

(defn record-group-percents [group-totals portfolio-value]
  (reduce #(record-group-percent %1 %2 portfolio-value)
          {}
          group-totals))

(defn by-type [assets]
  (let [portfolio-value (value-portfolio assets)]
    (-> assets
        group-assets
        value-asset-groups
        (record-group-percents portfolio-value))))

(defn record-asset-percent
  [asset-percents {:keys [ticker total-value]} portfolio-value]
  (assoc asset-percents
         ticker
         (* 100 (/ total-value portfolio-value))))

(defn record-asset-percents [assets]
  (let [portfolio-value (value-portfolio assets)]
    (reduce #(record-asset-percent %1 %2 portfolio-value)
            {}
            assets)))

(defn by-asset [assets]
  (-> assets
      record-asset-percents))
