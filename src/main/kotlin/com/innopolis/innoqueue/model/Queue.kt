package com.innopolis.innoqueue.model

import javax.persistence.*

@Entity
@Table(name = "queue")
open class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "queue_id", nullable = false)
    open var id: Long? = null

    @Column(name = "name", nullable = false, length = 64)
    open var name: String? = null

    @Column(name = "color", nullable = false, length = 64)
    open var color: String? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "creator_id", nullable = false)
    open var creator: User? = null

    @Column(name = "track_expenses", nullable = false)
    open var trackExpenses: Boolean? = false

    @Column(name = "link", nullable = false, length = 128)
    open var link: String? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "current_user_id", nullable = false)
    open var currentUser: User? = null

    @OneToMany(mappedBy = "queue")
    open var userQueues: MutableSet<UserQueue> = mutableSetOf()
}