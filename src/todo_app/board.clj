(ns todo-app.board
  (:require [todo-app.item :as t.item]))

(defn create [name items]
  {:board/name name
   :board/items items})

(defn add-new-item-to-board
  [{name :board/name items :board/items}
   new-item]
  (create name (conj items new-item)))

(defn remove-item-from-board
  [{:board/keys [name items]}
   item]
  (create name (remove #(= (:item/id %) (:item/id item)) items)))

(defn mark-item-as-done [board undone-item]
  (-> board
    (remove-item-from-board undone-item)
    (add-new-item-to-board (t.item/done undone-item))))

(defn mark-item-as-undone [board done-item]
  (-> board
    (remove-item-from-board done-item)
    (add-new-item-to-board (t.item/undone done-item))))
