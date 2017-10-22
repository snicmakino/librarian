<template>
  <div class="layout-padding">
    <q-data-table
      :data="table"
      :config="config"
      @refresh="refresh"
      @selection="selection"
   >
      <template slot="col-title" scope="cell">
        <span class="light-paragraph">{{cell.data}}</span>
      </template>

      <template slot="col-link" scope="cell">
        <q-btn v-if="cell.data.match(/www.amazon.co.jp/)" color="orange-6" small>
          Amazon
        </q-btn>
      </template>

    </q-data-table>
  </div>
</template>

<script>
  import {
    QDataTable,
    QField,
    QInput,
    QCheckbox,
    QSelect,
    QSlider,
    QBtn,
    QIcon,
    QTooltip,
    QCollapsible,
    clone
  } from 'quasar'
  import table from 'data/table.json'
  export default {
    components: {
      QDataTable,
      QField,
      QInput,
      QCheckbox,
      QSelect,
      QSlider,
      QBtn,
      QIcon,
      QTooltip,
      QCollapsible
    },
    methods: {
      changeMessage (props) {
        props.rows.forEach(row => {
          row.data.message = 'Gogu'
        })
      },
      deleteRow (props) {
        props.rows.forEach(row => {
          this.table.splice(row.index, 1)
        })
      },
      refresh (done) {
        this.timeout = setTimeout(() => {
          done()
        }, 5000)
      },
      selection (number, rows) {
        console.log(`selected ${number}: ${rows}`)
      },
      rowClick (row) {
        console.log('clicked on a row', row)
      }
    },
    beforeDestroy () {
      clearTimeout(this.timeout)
    },
    data () {
      return {
        table,
        config: {
          title: 'Books',
          refresh: true,
          noHeader: false,
          leftStickyColumns: 0,
          rightStickyColumns: 2,
          bodyStyle: {
            maxHeight: '500px'
          },
          rowHeight: '50px',
          responsive: true,
          pagination: {
            rowsPerPage: 15,
            options: [5, 10, 15, 30, 50, 500]
          }
        },
        columns: [
          {
            label: 'Title',
            field: 'title',
            width: '140px',
            filter: true,
            sort: true,
            type: 'String'
          },
          {
            label: 'Stock',
            field: 'stock',
            width: '70px',
            filter: true,
            sort: true,
            type: 'number'
          },
          {
            label: 'Link',
            field: 'link',
            width: '80px',
            sort: false
          }
        ],
        pagination: true,
        rowHeight: 50,
        bodyHeightProp: 'maxHeight',
        bodyHeight: 500
      }
    },
    watch: {
      pagination (value) {
        if (!value) {
          this.oldPagination = clone(this.config.pagination)
          this.config.pagination = false
          return
        }
        this.config.pagination = this.oldPagination
      },
      rowHeight (value) {
        this.config.rowHeight = value + 'px'
      },
      bodyHeight (value) {
        let style = {}
        if (this.bodyHeightProp !== 'auto') {
          style[this.bodyHeightProp] = value + 'px'
        }
        this.config.bodyStyle = style
      },
      bodyHeightProp (value) {
        let style = {}
        if (value !== 'auto') {
          style[value] = this.bodyHeight + 'px'
        }
        this.config.bodyStyle = style
      }
    }
  }
</script>

<style lang="stylus">
  .my-label
    padding 5px
    border-radius 3px
    display inline-block
</style>
