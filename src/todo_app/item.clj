(ns todo-app.item)

(defn create [id description]
  {:item/id          id
   :item/description description
   :item/done?       false})

(defn done [item]
  (assoc item :item/done? true))

(defn undone [item]
  (assoc item :item/done? false))
