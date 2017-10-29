<template>
  <div>
    <q-btn @click="$refs.basicModal.open()" color="secondary">Register</q-btn>

    <q-modal ref="basicModal" :content-css="{padding: '50px', minWidth: '50vw'}">
      <h4>Book Register</h4>
      <q-input v-model="text" float-label="Amazon URL Search" placeholder="Gigi"/>
      <q-input v-model="text" float-label="Title" />
      <q-input v-model="text" float-label="ISBN 10" />
      <q-input v-model="text" float-label="ISBN 13" />

      <q-btn color="primary" @click="$refs.basicModal.close()">Close</q-btn>
    </q-modal>

  </div>
</template>

<script>
  import {
    Toast,
    Ripple,
    QBtn,
    QIcon,
    QModal,
    QModalLayout,
    QToolbar,
    QToolbarTitle,
    QSearch,
    QList,
    QItem,
    QItemSide,
    QItemMain,
    QInput
  } from 'quasar'
  export default {
    components: {
      QBtn,
      QIcon,
      QModal,
      QModalLayout,
      QToolbar,
      QToolbarTitle,
      QSearch,
      QList,
      QItem,
      QItemSide,
      QItemMain,
      QInput
    },
    directives: {
      Ripple
    },
    data () {
      return {
        search: '',
        types: [
          {
            label: 'Basic',
            ref: 'basicModal'
          }
        ],
        position: 'bottom'
      }
    },
    methods: {
      notify (eventName) {
        Toast.create(`Event "${eventName}" was triggered.`)
      },
      openSpecialPosition (position) {
        this.position = position
        this.$nextTick(() => {
          this.$refs.positionModal.open()
        })
      }
    }
  }
</script>
