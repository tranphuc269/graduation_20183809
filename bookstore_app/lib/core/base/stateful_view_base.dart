import 'package:flutter/cupertino.dart';
import 'package:get/get.dart';
import 'package:lifecycle/lifecycle.dart';
import 'package:logger/logger.dart';
import 'package:meta/meta.dart';

import 'base_controller.dart';
import 'view_interface.dart';

/// ViewState
abstract class ViewState<Page extends StatefulViewBase,
        Controller extends BaseController>
    extends State<Page> // ignore: prefer_mixin
    with
        WidgetsBindingObserver,
        ViewInterface,
        LifecycleAware,
        LifecycleMixin {
  /// ViewState
  ViewState() {
    // logger.d('$runtimeType');
  }

  @override
  void onLifecycleEvent(LifecycleEvent event) {
  }
  /// globalKey
  final GlobalKey<State<StatefulWidget>> globalKey =
      GlobalKey<State<StatefulWidget>>();

  /// viewModel
  BaseController get controller => GetInstance().find<BaseController>();

  /// logger
  final logger = Logger();

  /// Implement the [Widget] you want to be displayed on View

  /// Should be used when need to perform some action on [initState] life cycle. Controller is injected on parameters.
  /// [super.initViewState] should be called before the actions you need to perform.
  ///
  /// ```dart
  /// void initViewState(CounterController controller) {
  ///   super.initViewState(controller);
  ///   controller.initializeCounter();
  /// }
  /// ```
  @mustCallSuper
  void initViewState() {
    WidgetsBinding.instance.addObserver(this);

    logger.d('Initializing state of $runtimeType');
  }

  /// Should be used when need to perform some action on [didChangeDependencies] life cycle. Controller is injected on parameters.
  /// [super.initViewState] should be called before the actions you need to perform. Like [didChangeDependencies], you can safely perform
  /// actions that depends on [BuildContext] here.
  ///
  /// ```dart
  /// void didChangeViewDependencies(CounterController controller) {
  ///   super.didChangeViewDependencies(controller);
  ///   controller.updateCounterOnDependencies();
  /// }
  /// ```
  @mustCallSuper
  void didChangeViewDependencies() {
    // logger.d('didChangeDependencies triggered on $runtimeType');
  }

  @override
  @mustCallSuper
  void didChangeDependencies() {
    didChangeViewDependencies();
    super.didChangeDependencies();
  }

  @override
  void didChangeAppLifecycleState(AppLifecycleState state) {
    if (mounted) {
      // switch (state) {
      //   case AppLifecycleState.inactive:
      //     logger.d('AppLifecycleState.inactive');
      //     onInActive();
      //     break;
      //   case AppLifecycleState.paused:
      //     logger.d('AppLifecycleState.paused');
      //     onPaused();
      //     break;
      //   case AppLifecycleState.resumed:
      //     logger.d('AppLifecycleState.resumed');
      //     onResumed();
      //     break;
      //   case AppLifecycleState.detached:
      //     logger.d('AppLifecycleState.detached');
      //     onDetached();
      //     break;
      // }
    }
  }

  /// Called when the application is in an inactive state and is not receiving user input.
  /// On iOS, this state corresponds to an app or the Flutter host store_select_item running in
  /// the foreground inactive state. Apps transition to this state when in a phone call,
  /// responding to a TouchID request, when entering the app switcher or the control center,
  /// or when the UIViewController hosting the Flutter app is transitioning.
  /// On Android, this corresponds to an app or the Flutter host store_select_item running in
  /// the foreground inactive state. Apps transition to this state when another
  /// activity is focused, such as a split-screens app, a phone call, a
  /// picture-in-picture app, a system dialog, or another window.
  ///
  /// Apps in this state should assume that they may be [onPaused] at any time.
  /// ```dart
  ///     class MyController extends Controller {
  ///       @override
  ///       void onInActive() => logger.d('App is in the background.');
  ///     }
  /// ```
  void onInActive() {}

  /// Called when the application is not currently visible to the user, not responding to user input, and running in the background.
  /// When the application is in this state, the engine will not call the Window.onBeginFrame and Window.onDrawFrame callbacks.
  /// Android apps in this state should assume that they may enter the detached state at any time.
  /// ```dart
  ///     class MyController extends Controller {
  ///       @override
  ///       void onPaused() => logger.d('App is paused.');
  ///     }
  /// ```
  void onPaused() {}

  /// Called when the application is visible and is responding to the user i.e. in the foreground and running.
  /// ```dart
  ///     class MyController extends Controller {
  ///       @override
  ///       void onResumed() => logger.d('App is resumed.');
  ///     }
  /// ```
  void onResumed() {}

  /// Called before the application is detached.
  /// When the application is in this state, the engine still runing but not attached to any store_select_item.
  ///
  /// ```dart
  ///     class MyController extends Controller {
  ///       @override
  ///       void onDetached() => logger.d('App is about to detach.');
  ///     }
  /// ```
  void onDetached() {}

  @override
  @nonVirtual
  void initState() {
    WidgetsBinding.instance.addObserver(this);
    initViewState();
    controller
      ..listenConnectivityStatus()
      ..onInitView();
    super.initState();
  }


  @override
  @mustCallSuper
  void dispose() {
    controller.cancelConnectivitySubscription();
    WidgetsBinding.instance.removeObserver(this);
    super.dispose();
  }
}

/// StatefulViewBase
abstract class StatefulViewBase extends StatefulWidget {
  /// StatefulViewBase constructor
  const StatefulViewBase();
}
